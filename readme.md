Utility which can track various github projects under multiple organizations.
Admin can add,remove organizations, projects. 

#Endpoints

Root /

Dashboard - All organisations and their projects.

Calls Supported.

Organisation.
    /organisation - GET - all organisation.
    /organisation/add - POST  - add organisation
    /organisation/<id> - organisation and repository contained. - GET

Project
    /project/add/organisation -> create project inside organisation. - POST
