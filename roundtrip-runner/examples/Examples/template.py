#!/usr/bin/python
import sys
import os
from string import Template

TestFile = Template('''import {AbstractRoundTripTest} from "com/enfore/n4js/n4idl/roundtrip/AbstractRoundTripTest";
import {$name#1} from "$foldername/$name";
import {$name#2} from "$foldername/$name";

/**
 * $name
 * 
 * $name#1 -> $name#2 -> $name#1
 * 
 * TODO add description
 */
export public class ${name}Test extends AbstractRoundTripTest<$name#1, $name#2> {
	
	@Override
	public instantiateOriginal() : $name#1 {
		// TODO implement
	}
	
	@Override
	public migrate(o1 : $name#1) : $name#2 {
		// TODO implement
	}

	@Override
	public migrateBack(o2 : $name#2) : $name#1 {
		// TODO implement
	}
}
	''')

ModelFile = Template('''
export public class $name#1 {
	// TODO add declaration

	constructor(@Spec spec : ~i~this) {}
}
export public class $name#2 {
	// TODO add declaration

	constructor(@Spec spec : ~i~this) {}
}
''')

InverseTestFile = Template('''import {$name#1} from "$foldername/$name";
import {$name#2} from "$foldername/$name";

import {InverseRoundTrip} from "com/enfore/n4js/n4idl/roundtrip/InverseRoundTrip";

import {RoundTripMigration} from "com/enfore/n4js/n4idl/roundtrip/RoundTripMigration";
import {${name}Test} from "$foldername/${name}Test"

/**
 * 
 * Inverse $name.
 * 
 * $name#2 -> $name#1 -> $name#2
 * 
 * Inverse round-trip of {@link ${name}Test}.
 */
export public class Inverse${name}Test extends InverseRoundTrip<$name#1, $name#2> {
	
	@Override
	public getRoundTripMigration() : RoundTripMigration<$name#1, $name#2> {
		return new ${name}Test();
	}
	
	@Override
	public instantiateOriginal() : $name#2 {
		// TODO implement
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
