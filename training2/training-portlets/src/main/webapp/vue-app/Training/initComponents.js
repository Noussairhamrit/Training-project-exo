import TrainingApp from './components/TrainingApp.vue';

const components = {
  'training-app': TrainingApp,
};

for (const key in components) {
  Vue.component(key, components[key]);
}
