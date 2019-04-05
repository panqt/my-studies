// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import MuseUI from 'muse-ui';
import 'muse-ui/dist/muse-ui.css';
Vue.use(MuseUI);
import 'material-design-icons/iconfont/material-icons.css'

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  render:h=>h(App)
})
