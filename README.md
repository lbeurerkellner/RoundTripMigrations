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

After launching the Eclipse IDE, go to Help/Install New Software.

![Help/Install New Software](/img/1_install_viewer.png)

Enter a new update site:

https://jevopi.de/updatesite/com.enfore.n4js.n4idl.roundtrip.site/site.xml

Select the Round-Trip Runner and install it.

![Select Runner](/img/2_select_runner_for_installation.png)

## Import Projects

Go to File / Import ... and select "Projects from Git" and "Clone URI".
Use this repository, i.e. use

https://github.com/jpilgrim/RoundTripMigrations.git

as the URI.

Select the master branch and select all projects on the "Import Projects" wizard page.

![Select Projects](/img/3_import_projects.png)


## Run Tests

### Install missing dependencies

You probably get some compile errors due to missing dependencies. 
In order to resolve all dependencies, open a package.json file with errors and choose quickfix "Install all missing NPMs" (by hovering over the error message of any dependency). Alternatively you can run the tool "Install all missing" (button with two gears found in the toolbar).

![Quickfix](/img/4_fix_dependencies.png)


### Run the scenario tests

In order to run all tests of the catalog, right-click the project “scenario.catalog” and select “Run As / Test in Node.js”. 

![Run Tests](/img/5_run_tests.png)

You will then see a JUnit-Runner like view executing all the tests.

![Test Results](/img/6_test_results.png)

### Use the RoundTrip Viewer

In order to view the object graph with the traces and migrations, go to Window / Show View / Other
and select the RoundTip Runner / Full Round Trip Object Graph.

![Open RT Viewer](/img/7_open_round_trip_viewer.png)

For  any test the scenario.catalog project (i.e., an n4idl file which file name as a suffix "Test") use the context menu (right-click on file name) and select "Run As / Launch with N4IDL Roundtrip runner".

![Open RT Viewer](/img/8_run_with_viewer.png)

You will then see the object graph in the viewer.

![Open RT Viewer](/img/9_view_graph.png)

# License

The content found in this project is made available under the Eclipse Public License 2.0.
