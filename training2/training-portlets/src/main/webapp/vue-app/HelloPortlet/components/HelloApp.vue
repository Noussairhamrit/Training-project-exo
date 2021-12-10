<template>
  <div class="helloContaner">
    <!--    <p>{{ clientArray }} </p>-->
    <test-app />
    <v-btn
      depressed
      color="primary"
    >
      Primary
    </v-btn>
    <v-data-table
      :headers="headers"
      :items="clientArray"
      class="elevation-1"
    />
    
    <!--    <tr>-->
    <!--      <th>id</th>-->
    <!--      <th>name</th>-->
    <!--    </tr>-->
    <!--    <div v-for="item in clientList">-->
    <!--      <th>{{ item.id }}</th>-->
    <!--      <th>{{ item.name }}</th>-->
    <!--    </div>-->
  </div>
</template>
<script>
import {getusers} from '../../../js/trainingService.js';

export default {

  data(){
    return {
      clientList: [],
      headers: [
        {text: 'id', value: 'id'},
        {text: 'name', value: 'name'}
      ]
    };
  },
  computed: {
    clientArray() {return  this.clientList;}
  },
  mounted() {
    this.getClient();

  },
  methods: {
    getClient(){
      return getusers().then(data => {
        this.clientList = data;
      });
    }
  }

};
</script>