<template>
  <div id="app">

    <mu-appbar style="width: 100%;" color="primary">
      <mu-button icon slot="left" @click="open = !open">
        <mu-icon value="menu"></mu-icon>
      </mu-button>
      Title
      <mu-menu slot="right">
        <mu-button icon><mu-icon value="add"></mu-icon></mu-button>
        <mu-list slot="content">
          <mu-list-item button>
            <mu-list-item-content>
              <mu-list-item-title>Menu Item 1</mu-list-item-title>
            </mu-list-item-content>
          </mu-list-item>
          <mu-list-item button>
            <mu-list-item-content>
              <mu-list-item-title>Menu Item 2</mu-list-item-title>
            </mu-list-item-content>
          </mu-list-item>
        </mu-list>
      </mu-menu>
    </mu-appbar>

    <div class="main">
      <router-view/>
    </div>


    <mu-bottom-nav>
      <router-link to="/bookshelf">
        <mu-bottom-nav-item title="书架" icon="import_contacts"></mu-bottom-nav-item>
      </router-link>
      <router-link to="/discovery">
        <mu-bottom-nav-item title="发现" icon="explore"></mu-bottom-nav-item>
      </router-link>
      <router-link to="/user-info">
        <mu-bottom-nav-item title="我的" icon="person"></mu-bottom-nav-item>
      </router-link>
    </mu-bottom-nav>


    <mu-drawer :open.sync="open" :docked="docked" :right="position === 'right'">
      <mu-list>
        <mu-list-item button>
          <mu-list-item-title>Menu Item 1</mu-list-item-title>
        </mu-list-item>
        <mu-list-item button>
          <mu-list-item-title>Menu Item 2</mu-list-item-title>
        </mu-list-item>
        <mu-list-item @click="open = false" button>
          <mu-list-item-title>Close</mu-list-item-title>
        </mu-list-item>
      </mu-list>
    </mu-drawer>

  </div>
</template>

<script>
  export default {
    name: 'App',
    data() {
      return {
        shift: 'movies',
        docked: false,
        open: false,
        position: 'left'
      }
    }
  }
</script>

<style>
  html, body {
    height: 100%;
    width: 100%;
  }

  #app {
    padding: 0;
    margin: 0;
    width: 100%;
    height: 100%;
  }

  .mu-appbar{
    position: fixed;
  }

  .main{
    padding-top: 56px;
    padding-bottom: 60px;
  }

  .mu-bottom-nav {
    width: 100%;
    position: fixed;
    bottom: 0;
  }

 .mu-bottom-nav a{
    min-width: 80px;
    max-width: 168px;
    color: inherit;
    display: block;
    flex: 1;
  }
</style>
