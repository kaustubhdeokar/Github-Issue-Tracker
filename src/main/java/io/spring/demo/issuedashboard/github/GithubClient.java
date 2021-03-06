package io.spring.demo.issuedashboard.github;

import io.spring.demo.issuedashboard.GithubProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Component
public class GithubClient {

    private static final String EVENT_ISSUES_URL = "https://api.github.com/repos/{owner}/{repo}/issues/events";

    private final RestTemplate restTemplate;


    public GithubClient(RestTemplateBuilder builder, GithubProperties properties) {
        this.restTemplate = builder.
                additionalInterceptors(new GithubAppTokenInterceptor(properties.getToken()))
                .build();

    }

    public ResponseEntity<RepositoryEvent[]> fetchEvents(String orgName, String repoName) {

        return this.restTemplate.getForEntity(EVENT_ISSUES_URL, RepositoryEvent[].class, orgName, repoName);
    }

    public List<RepositoryEvent> fetchEventsAsList(String orgName, String repoName) {

        ResponseEntity<RepositoryEvent[]> responseEntity = fetchEvents(orgName, repoName);
        RepositoryEvent[] body = responseEntity.getBody();
        RepositoryEvent[] repositoryEvents = Arrays.copyOfRange(body, 0, 10);
        return Arrays.asList(repositoryEvents);
    }


    private static class GithubAppTokenInterceptor implements ClientHttpRequestInterceptor {

        private final String token;

        GithubAppTokenInterceptor(String token) {
            this.token = token;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes,
                                            ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
            if (StringUtils.hasText(this.token)) {
                byte[] basicAuthValue = this.token.getBytes(StandardCharsets.UTF_8);
                httpRequest.getHeaders().set(HttpHeaders.AUTHORIZATION,
                        "Basic " + Base64Utils.encodeToString(basicAuthValue));
            }
            return clientHttpRequestExecution.execute(httpRequest, bytes);
        }

    }

}
