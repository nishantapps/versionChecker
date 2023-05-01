const versionChecker = require('./index');

const checker = versionChecker();

// Set the current version to 1.0.0
checker.setCurrentVersion('1.0.0');

// Try to update a package that is up-to-date
checker.syncVersion('lodash');

// Try to update a package that is outdated
checker.syncVersion('moment');
