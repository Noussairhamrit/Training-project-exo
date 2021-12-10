<template>
  <div class="helloContaner">
    <h1 class="demoo">
      Client Portlet
    </h1>
    <v-data-table
      :headers="headers"
      :items="client"
      class="elevation-1"
      @loadClient="allClients()"
    />
    <h1>Add Client</h1>
    <add-client />
    <h1>Crud Client</h1>
    <extension-registry-components
        name="ilhem"
        type="activity-ilhem"
    />
    <crud-client />
  </div>
</template>

<script>
import {getAllClient} from '../../../js/trainingService.js';

export default {

  data(){
    return  {
      client: [],
      headers: [
        {text: 'id', value: 'id'},
        {text: 'prenom', value: 'prenom'},
        {text: 'name', value: 'name'},
        {text: 'addresse', value: 'addresse'},
        {text: 'email', value: 'email'},
      ]
      
    };
  },
  computed: {
    clientsList() {
      return this.client;
    }
  },
  created() {
    this.$root.$on('refresh-table', (data)=> {
      this.client.push(data);
      console.warn('ola', data);
    });
  },
  mounted() {
    this.allClients() ;
    console.log('console.log  mounted app',this.client);
  },
  methods: {
    allClients(){
      return getAllClient().then(data=>{
        this.client=data;
        console.log('console.log methods app',this.client);
      }).catch(error => console.log(error));
    }
  }
};
</script>
<style>
.demoo{
  position: center;
  margin: 10px;
  color: crimson;
}
</style>