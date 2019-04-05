import Vue from 'vue'
import Router from 'vue-router'
import bookshelf from '@/components/bookshelf'
import discovery from '@/components/discovery'
import userInfo from '@/components/user-info'

Vue.use(Router)

export default new Router({
  linkActiveClass:"mu-bottom-item-active",
  routes: [
    {
      path: '/',
      name: 'index',
      component: bookshelf
    },
    {
      path: '/bookshelf',
      name: 'bookshelf',
      component: bookshelf
    },
    {
      path: '/discovery',
      name: 'discovery',
      component: discovery
    },
    {
      path: '/user-info',
      name: 'user-info',
      component: userInfo
    }
  ]
})
