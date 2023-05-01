function versionChecker() {
    var current = "";
  
    function setCurrentVersion(currentVersion) {
      current = currentVersion;
    }
  
    async function syncVersion(packageName) {
        const axios = require('axios');
        const url = `https://registry.npmjs.org/${packageName}`;
        const response = await axios.get(url);
        const latestVersion = response.data['dist-tags'].latest;
      
        if (current == latestVersion) {
          console.log(`${packageName} ${current} is up-to-date`);
        } else {
          const readline = require('readline').createInterface({
            input: process.stdin,
            output: process.stdout
          });
      
          readline.question(`${packageName} ${current} is outdated. Do you want to update it? (Y/n) `, async (answer) => {
            readline.close();
            if (answer.toLowerCase() === 'y' || answer.toLowerCase() === 'yes') {
              const { execSync } = require('child_process');
              const output = execSync(`npm view ${packageName} readme && npm install ${packageName}@${latestVersion}`).toString();
              console.log(output);
              const changelogUrl = `https://registry.npmjs.org/-/npm/v1/changelog/${packageName}/latest`;
              const changelogResponse = await axios.get(changelogUrl);
              const changelog = changelogResponse.data;
              console.log(`Changelog for ${packageName} ${latestVersion}:\n${changelog}`);
            } else {
              console.log(`${packageName} ${current} was not updated`);
            }
          });
        }
      }
      
  
    return { setCurrentVersion, syncVersion };
  }

module.exports = versionChecker;
  