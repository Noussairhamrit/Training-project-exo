const path = require('path');

let config = {
  context: path.resolve(__dirname, '.'),
  // set the entry point of the application
  // can use multiple entry
  entry: {
    training: './src/main/webapp/vue-app/Training/main.js',
    hello: './src/main/webapp/vue-app/HelloPortlet/main.js',
    demo: './src/main/webapp/vue-app/demo/main.js',
    noussair: './src/main/webapp/vue-app/noussair/main.js',
    client: './src/main/webapp/vue-app/clientPortlet/main.js',
    extensionApp: './src/main/webapp/vue-app/extension/main.js',
  },
  output: {
    filename: 'js/[name].bundle.js',
    libraryTarget: 'amd'
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: [
          'babel-loader',
          'eslint-loader'
        ]
      },
      {
        test: /\.vue$/,
        use: [
          'vue-loader',
          'eslint-loader'
        ]
      }
    ]
  },
  externals: {
    vue: 'Vue',
    vuetify: 'Vuetify',
    jquery: '$',
  },
};

module.exports = config;