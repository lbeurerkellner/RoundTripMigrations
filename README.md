# Round Trip Migrations

Source code developed by Luca Beurer-Kellner as part of his bachelor thesis.
The thesis is available at

https://www.informatik.hu-berlin.de/de/forschung/gebiete/mse/Abschlussarbeiten/Abgeschlossen/bachelorkelner

## Requirements

In order to execute the migrations, import the projects found in folder "migrations" into the workspace of the Eclipse N4JS IDE. Nightly builds of this IDE can be found at 

https://projects.eclipse.org/projects/technology.n4js/downloads

In order to resolve all dependencies, open a package.json file with errors and choose quickfix "Install all missing RPMs". Alternatively you can run the tool "Install all missing" (button with two gears found in the toolbar).

## Run Tests

In order to run all tests of the catalog, right-click the project “scenario.catalog” and select “Run As / Test in Node.js”

## Round-Trip Runner

Additionally you may install the plugins found in the folder "roundtrip-runner". They provide a special runner and a view for showing object diagrams of the migration. This is explained in the appendix of the thesis.

# License

The content found in this project is made available under the Eclipse Public License 2.0.
