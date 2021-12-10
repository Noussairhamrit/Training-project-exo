import noussair from './components/noussair.vue';

const components = {
  'noussair-app': noussair,
};

for (const key in components) {
  Vue.component(key, components[key]);
}
