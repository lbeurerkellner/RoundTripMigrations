# Round Trip Runner for the N4JS IDE

This plugin extends the N4JS IDE by a runner that allows to execute N4IDL migrations and visualise their implications in round-trip scenarios.

# Project Structure

* **plugins** Eclipse Plugin Projects that are required to use the Round Trip Runner. These bundles depend on the eclipse/n4js project.
* **features** An Eclipse Feature project to include the Round Trip Runner in a launch configuration or product definition
* **n4js** Required N4JS runtime libraries in order to use the round trip runner

