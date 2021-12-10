import './initComponents.js';

Vue.use(Vuetify);

const vuetify = new Vuetify(eXo.env.portal.vuetifyPreset);


// getting language of user
const lang = eXo && eXo.env && eXo.env.portal && eXo.env.portal.language || 'en';

const resourceBundleName = 'locale.addon.Training';
const url = `${eXo.env.portal.context}/${eXo.env.portal.rest}/i18n/bundle/${resourceBundleName}-${lang}.json`;
const appId = 'demoPortletContainer';


export function init() {
  exoi18n.loadLanguageAsync(lang, url).then(i18n => {
    // init Vue app when locale ressources are ready
    Vue.createApp({
      template: '<demo-app></demo-app>',
      i18n,
      vuetify,
    }, `#${appId}`, 'demo Portlet');
  });
}
