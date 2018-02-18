# ServiceAvalability
To check the availability of given service by pinging all the available instances on demand:


Steps to use:
In ServiceInstanceConstant class:
1. Replace  SERVICE_URL with actual service URL
2. Replace SERVICE_INSTANCES with actual number of instances of that service
(You can add as many service as you want)
3. In ServiceInstanceManager class update service name in requestedServiceEndpoints() method accordinly and you are good to go
