import extensionTest from './components/extensionTest.vue';

Vue.use(Vuetify);

const vuetify = new Vuetify(eXo.env.portal.vuetifyPreset);


////////////////////////////////////////////////////////////////////
Vue.component('extension-test', extensionTest);

// Register new extension for actions in the footer
extensionRegistry.registerComponent('ActivityFooter', 'activity-footer-action', {
  id: 'Test',
  vueComponent: Vue.options.components['extension-test'],
  rank: 10,
});

extensionRegistry.registerComponent('ilhem','activity-ilhem' ,{
  id: 'Test',
  vueComponent: Vue.options.components['extension-test'],
  rank: 10,
});

extensionRegistry.registerComponent('noussair', 'activity-noussair', {
  id: 'Test',
  vueComponent: Vue.options.components['extension-test'],
  rank: 10,
});
////////////////////////////////////////////////////////////////////

// getting language of user
const lang = eXo && eXo.env && eXo.env.portal && eXo.env.portal.language || 'en';
const resourceBundleName = 'locale.addon.Training';
const url = `${eXo.env.portal.context}/${eXo.env.portal.rest}/i18n/bundle/${resourceBundleName}-${lang}.json`;


const appId = 'extensionApp';


export function init() {
  exoi18n.loadLanguageAsync(lang, url)
    .then(i18n => {
    // init Vue app when locale ressources are ready
      new Vue({
        render: h => h(extensionTest),
        i18n,
        vuetify,
      }, `#${appId}`, 'extensionApp');
    });
}
