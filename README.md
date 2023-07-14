<p align="center">
<img src="https://user-images.githubusercontent.com/99231654/235589378-ab62d350-4480-4d4b-a312-9c48f5a80056.png">
</p>

# About
`versionChecker()` is a Node.js module that allows you to check and update the version of an npm package. It provides two functions: setCurrentVersion() and syncVersion().

The `setCurrentVersion()` function takes a string parameter representing the current version of the package you want to check. This function sets the current variable to the specified value.

The `syncVersion()` function takes a string parameter representing the name of the package you want to check. It uses the npm registry API to get the latest version of the package and compares it to the current version set by setCurrentVersion(). If the versions are the same, it logs a message saying that the package is up-to-date. If they are different, it prompts the user to update the package. If the user chooses to update, it installs the latest version of the package and displays the changelog.

This module uses the `axios` and readline Node.js packages to make HTTP requests and prompt the user for input. It also uses the execSync function from the child_process module to install the latest version of the package.

To use this module, you first need to install it using npm. You can then require it in your Node.js script and create a new instance of it using the `versionChecker()` function. You can then set the current version using `setCurrentVersion()` and check the version of a package using `syncVersion()`.


# Installation 

You can install versionchecker using NPM

```
npm i @developerso/versionchecker
```

# Usage

First, require the module in your Node.js script:

```
const versionChecker = require('@developerso/versionchecker');
```
Then, create a new instance of the module and set the current version of the package you want to check:

```
const vc = versionChecker();
vc.setCurrentVersion('1.0.0');
```
Finally, call the `syncVersion()` method with the name of the package you want to check:

```
vc.syncVersion('package-name');
```

The module will check if the latest version of the package is different from the current version you set. If it is, it will prompt you to update the package. If you choose to update, it will install the latest version and display the changelog.

# Example

```
const versionChecker = require('version-checker');

const vc = versionChecker();
vc.setCurrentVersion('1.0.0');

vc.syncVersion('express');
```

# License 

This project is licensed under `MIT`
