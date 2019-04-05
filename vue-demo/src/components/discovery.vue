<template>
  <div>

    <mu-flex justify-content="center">
      <!--<mu-paper :z-depth="1">-->
        <!--<mu-appbar color="primary">-->
          <!--<mu-button icon slot="left">-->
            <!--<mu-icon value="menu"></mu-icon>-->
          <!--</mu-button>-->
          <!--Photo-->
        <!--</mu-appbar>-->
        <mu-grid-list class="gridlist-demo">
          <mu-sub-header>December</mu-sub-header>
          <mu-grid-tile v-for="tile, index in list" :key="index">
            <img :src="tile.image" >
            <span slot="title">{{tile.title}}</span>
            <span slot="subTitle">by <b>{{tile.author}}</b></span>
            <mu-button slot="action" icon>
              <mu-icon value="star_border"></mu-icon>
            </mu-button>
          </mu-grid-tile>
        </mu-grid-list>
      <!--</mu-paper>-->
    </mu-flex>

  </div>
</template>

<script>

  import elasticsearch from '../assets/elasticsearch.png';
  import rabbitmq from '../assets/rabbitmq.jpg';
  import redis from '../assets/redis.png';
  import fastdfs from '../assets/fastdfs.png';
  import honey from '../assets/logo.png';
  import morning from '../assets/logo.png';
  import vegetables from '../assets/logo.png';
  import waterPlant from '../assets/logo.png';
  export default {
    name: "discovery",
    data () {
      return {
        list: [{
          image: elasticsearch,
          title: 'elasticsearch',
          author: 'Myron'
        }, {
          image: rabbitmq,
          title: 'rabbitmq',
          author: 'Linyu'
        }, {
          image: redis,
          title: 'redis',
          author: 'ruolin'
        }, {
          image: fastdfs,
          title: 'fastdfs',
          author: 'kakali'
        }, {
          image: honey,
          title: 'Honey',
          author: 'yuyang'
        }, {
          image: morning,
          title: 'Morning',
          author: 'mokayi'
        }, {
          image: vegetables,
          title: 'Vegetables',
          author: 'NUyyyyyyy'
        }, {
          image: waterPlant,
          title: 'water',
          author: 'TDDyyyyyyy'
        }]
      }
    }
  }

    console.log("发现")
</script>

<style scoped>
  .gridlist-demo{
    width: 100%;
    height: 100%;
    overflow-y: auto;
  }
</style>
