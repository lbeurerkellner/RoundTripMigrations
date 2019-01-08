#!/usr/bin/python
import sys
import os
from string import Template

TestFile = Template('''import {$name, migrate, migrateBack} from "$foldername/$name";
import {InstanceAssert} from "com/enfore/n4js/n4idl/assert/InstanceAssert";
import {FunctionContextRoundTripTest} from "com/enfore/n4js/n4idl/context/FunctionContextRoundTripTest";
import {Assert} from "org/eclipse/n4js/mangelhaft/assert/Assert";

export public class ${name}Test extends FunctionContextRoundTripTest<$name#1, $name#2> {
	
	@Override
	protected migration = migrate;
	@Override
	protected backMigration = migrateBack;
	
	@Override
	public instantiateOriginal() : $name#1 {
		let o1 = new $name#1();
	
		// TODO initalise original instance	
		
		return o1;
	}
	
	
	@Override
	public assertMigratedInstance(migrated: $name#2) {
		// TODO make assertions wrt the migrated instance
	}
	
	@Override
	public assertRoundTripInstance(roundTrip: $name#1) {
		InstanceAssert.equalSerialisation(roundTrip, this.instantiateOriginal(), 
			"The serialisation of the round-trip matches the original serialisation.");
	}
}
''')

ModelFile = Template('''import {MigrationContext} from "com/enfore/n4js/n4idl/context/MigrationContext";

export public class $name#1 {
	// TODO add declarations
}
export public class $name#2 {
	// TODO add declarations
}
@Migration
export function migrate(context : MigrationContext, 
	o1 : $name#1) : $name#2 {
	// obtain previous revision
	const previousRevision = context.<$name#2>getOriginal(o1);

	let o2 = new $name#2();

	// TODO implement migration

	return o2;
}

@Migration
export function migrateBack(context : MigrationContext, 
	o2 : $name#2) : $name#1 {
	// obtain previous revision
	const previousRevision = context.<$name#1>getOriginal(o2);
	
	let o1 = new $name#1();

	// TODO implement back-migration
	
	return o1;
}
''')

InverseTestFile = Template('''import {$name, migrate, migrateBack} from "$foldername/$name";
import {InstanceAssert} from "com/enfore/n4js/n4idl/assert/InstanceAssert";
import {FunctionContextRoundTripTest} from "com/enfore/n4js/n4idl/context/FunctionContextRoundTripTest";
import {Assert} from "org/eclipse/n4js/mangelhaft/assert/Assert";

export public class Inverse${name}Test extends FunctionContextRoundTripTest<$name#2, $name#1> {
	
	@Override
	protected migration = migrateBack;
	@Override
	protected backMigration = migrate;
	
	@Override
	public instantiateOriginal() : $name#2 {
		let o2 = new $name#2();
	
		// TODO initialise original instance	
		
		return o2;
	}
	
	
	@Override
	public assertRoundTripInstance(roundTrip : $name#2) {
		InstanceAssert.equalSerialisation(roundTrip, this.instantiateOriginal(),
			"The serialisation of the round-trip matches the original serialisation.");		
	}
	
	@Override
	public assertMigratedInstance(migrated : $name#1) {
		// TODO make assertion wrt the migrated instance
	}
}
''')

def createTestFile(name, foldername):
	f = open(foldername + "/" + name + "Test.n4idl", "w")		
	f.write(TestFile.substitute(name=name, foldername=foldername))
	f.close()
def createInverseTestFile(name, foldername):
	f = open(foldername + "/Inverse" + name + "Test.n4idl", "w")		
	f.write(InverseTestFile.substitute(name=name, foldername=foldername))
	f.close()
def createModelFile(name, foldername):
	f = open(foldername + "/" + name + ".n4idl", "w")		
	f.write(ModelFile.substitute(name=name))
	f.close()

if len(sys.argv) != 3:
	print("USAGE python template.py <NAME> <FOLDERNAME>")
	sys.exit(0)

name = sys.argv[1]
foldername = sys.argv[2]

print("Creating new example with name '" + name + "'")

os.mkdir(foldername)

createTestFile(name, foldername)
createInverseTestFile(name, foldername)
createModelFile(name, foldername)
