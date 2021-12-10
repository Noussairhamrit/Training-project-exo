import ClientApp from './components/ClientApp.vue';
import AddClient from './components/AddClient.vue';
import crudClient from  './components/crudClient.vue';
import extensionTest from '../extension/components/extensionTest.vue';



const components = {
  'client-app': ClientApp,
  'add-client': AddClient,
  'crud-client': crudClient,
  'extension-test':extensionTest,


};

for (const key in components) {
  Vue.component(key, components[key]);
}
