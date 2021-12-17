#Projects-Visualization
````Projects-Visualization uses ElasticSearch and Kibana to visualize users projects and commits in an representative way. :)````

####[Link to Project Confluence]("https://kingcode.atlassian.net/wiki/spaces/KINGCODE/pages/504299521/PROJECTS-VISUALIZATION")

####[Link to Project Jira]("https://kingcode.atlassian.net/jira/software/c/projects/PHOTCODE/issues/PHOTCODE-6?filter=allissues")

#### [Google Meet Channel](https://meet.google.com/urv-ukqm-kpc?pli=1&authuser=3)

#### [Github Repo](https://github.com/KING-0-CODE/Projects-Visualization.git)

#### [Confluence](https://kingcode.atlassian.net/wiki/spaces/KINGCODE/pages/504299521/PROJECTS-VISUALIZATION)

#### [Jira](https:)

#### [UML BE Diagram](https:)

#### [Stage URL Backend](https:)

#### [Stage URL Kibana Frontend](https:)

#### [Production URL](https:)

## Backend

### Docker
We use docker-compose to set up ElasticSearch and Kibana, which is needed to run the application.  
Please follow these steps:
###### 1. Install Docker
Docker Desktop provides you a Desktop solution for managing your containers (including Docker Engine, Docker Compose)
https://www.docker.com/products/docker-desktop
###### 2. Run the containers
Open *<projectPath>\src\main\resources\docker* in command line or right-click on docker folder in IntelliJ and select *"Open in / Terminal"*
To build, (re)create and start your containers in an interactive shell, type the following command.
```
docker-compose up
```
With parameter *-d* it is possible to let docker container run as a daemon which means that the docker container would run in the background completely detached from your current shell.
```
docker-compose up -d
```
If you want to start a specific container, type the following command.
```
docker-compose up -d <containerName>
```
To list your containers, type the following command.
```
docker-compose ps -a
```
```
NAME                COMMAND                  SERVICE             STATUS
     PORTS
elasticsearch       "/bin/tini -- /usr/l…"   elasticsearch       running        
     0.0.0.0:9201->9200/tcp, 0.0.0.0:9301->9300/tcp
kibana              "/bin/tini -- /usr/l…"   kibana              running        
     0.0.0.0:5601->5601/tcp
```
The following command stops containers and removes containers, networks, volumes, and images created by *docker-compose up*.
```
docker-compose down
```
For further explanations, please see the [docker-compse reference](https://docs.docker.com/compose/reference/).

### Elastic 
#### To check elasticsearch server go to ```http://localhost:9200/```

### Kibana
#### To check Kibana server go to ```http://localhost:5601/app/dev_tools#/console```
#### User these commands for queries:
```
GET _cluster/health

GET _nodes/stats

GET king_code_projectsvisualization_github_projects

PUT king_code_projectsvisualization_github_projects

PUT github_projects

POST githubcommits/_doc 
{
  "message":"message..."
}

PUT github_commits/_doc/1
{
  "message":"message..."
}


```

### Team

* Product Owner: []()
* Project manager: []()
* BE Dev: [Mehran Hosseini](AjaxCube@Gmail.com)
* BE Dev: [Sadra Babai]()
* Production: []()


### Useful Documentation for this App:
####[GitHub Doc](https://docs.github.com/en/rest/reference/repos)
####[Elasticsearch](https://docs.github.com/en/rest/reference/repos)
####[Kibana](https://docs.github.com/en/rest/reference/repos)
