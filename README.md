# Round Trip Migrations

Source code developed by Luca Beurer-Kellner as part of his bachelor thesis.
The thesis is available at

https://www.informatik.hu-berlin.de/de/forschung/gebiete/mse/Abschlussarbeiten/Abgeschlossen/bachelorkelner

This thesis contains a details description of the 22 round-trip scenarios.

## Requirements

You need the Eclipse N4JS IDE for running the migrations. Nightly builds of this IDE can be found at 

https://projects.eclipse.org/projects/technology.n4js/downloads

Download the IDE for your OS, extract the archive and run the IDE.


### Round-Trip Runner

Additionally you may install the plugins found in the folder "roundtrip-runner". They provide a special runner and a view for showing object diagrams of the migration. This is explained in the appendix of the thesis.

After launching the Eclipse IDE, go to Help/Install New Software and enter a new update site:

https://jevopi.de/updatesite/com.enfore.n4js.n4idl.roundtrip.site/site.xml

Select the Round-Trip Runner and install it.

## Import Projects

Go to File / Import ... and select "Projects from Git" and "Clone URI".
Use this repository, i.e. use

https://github.com/jpilgrim/RoundTripMigrations.git

as the URI.

Select the master branch and select all projects on the "Import Projects" wizard page.



## Run Tests

### Install missing dependencies

You probably get some compile errors due to missing dependencies. 
In order to resolve all dependencies, open a package.json file with errors and choose quickfix "Install all missing NPMs". Alternatively you can run the tool "Install all missing" (button with two gears found in the toolbar).

### Run the scenario tests

In order to run all tests of the catalog, right-click the project “scenario.catalog” and select “Run As / Test in Node.js”. You will then see a JUnit-Runner like view executing all the tests.

### Use the RoundTrip Viewer

In order to view the object graph with the traces and migrations, go to Window / Show View / Other
and select the RoundTip Runner / Full Round Trip Object Graph.
For  any test the scenario.catalog project (i.e., an n4idl file which file name as a suffix "Test") use the context menu (right-click on file name) and select "Run As / Launch with N4IDL Roundtrip runner".

# License

The content found in this project is made available under the Eclipse Public License 2.0.
