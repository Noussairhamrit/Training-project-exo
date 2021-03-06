const path = require('path');
const merge = require('webpack-merge');
const webpackCommonConfig = require('./webpack.common.js');

// the display name of the war
const app = 'training';

// add the server path to your server location path
const exoServerPath = '/home/exo/work/binaries/plf-enterprise-tomcat-standalone-6.3.x-20211101.180147-634/platform-6.3.x-SNAPSHOT';

let config = merge(webpackCommonConfig, {
  output: {
    path: path.resolve(`${exoServerPath}/webapps/${app}/`)
  },
  devtool: 'inline-source-map'
});

module.exports = config;
