# Restfull  Webservices Jakarta EE

## Steps to set up this project

- Download and install Wildfly (v 26 used)
- (Optional) Add user to grant admin console access executing `\bin\add-user.bat` follow steps
- Execute `\bin\standalone.bat` file (Windows 11) from wildfly folder installation
- (Start Wildfly is needed) Create a new one Datasource in [Wildfly Console](http://127.0.0.1:9990/console/index.html) -> Configuration -> Datasources && Drivers (Add Datasource) -> MySQL in this case.
  Datasource's named must be `MySqlDS`. To connect MySQL database.
- (IntelliJ IDE) required. Run program with `jakarta-jax-rs [wildfly:deploy]` configuration IntelliJ IDE selected. This deploys program to the local [Wildfly](http://127.0.0.1:9990/console/index.html) -> Deployments
- Happy coding !