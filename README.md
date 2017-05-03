# Jackson Minor Version Compatibility checker

## Background

Jackson project only guarantees cross-component compatibility within each
minor release (that is, any combination of components with same minor version,
regardless of patch version, should work without problems) (*).

But in practice project tries to retain some level of cross-minor-version compatibility
between adjacent minor versions. This project is created to verify compatibility
expectations.

(*) Note: user code that uses Jackson Public API has much stronger backward-compatibility
  guarantees -- code written against specific major version should remain working
  against all subsequent minor revisions: code that worked with 2.1, for example,
  should still work, without recompilation, against 2.9.

## What is checked

This repository contains cross-minor-version tests for checking version compatibility
between certain categories of minor versions, based on dependencies between Jackson
components.

Specifically what is being checked is the case of:

* New versions of Jackson "core" components (annotations, streaming, databind)
* Old versions of:
    * Dataformat modules
    * (some) Datatype modules (guava, joda)
    * Other: JAXB annotation module

## Notes on observed compatibility

### Jackson 2.8

### Jackson 2.9

Version 2.9 of core components appear compatiblity with dataformat and datatype modules
of:

* 2.8
* 2.7

but does not work with version 2.6 or earlier.



