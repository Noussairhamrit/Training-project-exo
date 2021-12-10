import HelloApp from './components/HelloApp.vue';
import TestApp from './components/TestApp.vue';

const components = {
  'hello-app': HelloApp,
  'test-app': TestApp
};

for (const key in components) {
  Vue.component(key, components[key]);
}
