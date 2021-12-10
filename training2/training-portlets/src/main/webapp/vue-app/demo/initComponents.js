import DemoApp from './components/DemoApp.vue';


const components = {
  'demo-app': DemoApp,
};

for (const key in components) {
  Vue.component(key, components[key]);
}
