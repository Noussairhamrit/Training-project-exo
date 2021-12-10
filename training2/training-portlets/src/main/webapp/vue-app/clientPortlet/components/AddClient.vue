<template>
  <div class="test-extention-div">

    <div id="app" class="modal-form">
      <v-form
        ref="form"
        v-model="valid"
        lazy-validation
      >
        <v-text-field
          v-model="form.prenom"
          :rules="nameRules"
          label="firstname"
          required
        />
        <v-text-field
          v-model="form.name"
          :rules="nameRules"
          label="Name"
          required
        />
        <v-text-field
          v-model="form.email"
          :rules="emailRules"
          label="E-mail"
          required
        />
        <v-text-field
          v-model="form.addresse"
          :rules="nameRules"
          label="addresse"
          required
        />
        <v-btn
          :disabled="!valid"
          color="#64DD17"
          class="mr-4"
          @click="validate"
        >
          Validate
        </v-btn>
        <extension-registry-components
            name="noussair"
            type="activity-noussair"
          />
      </v-form>
    </div>
    <div class="test-extension-place">
      extension test
    </div>
  </div>
</template>
<script>
import {addClient} from '../../../js/trainingService.js';


export default {
  name: 'AddClient',
  data: () => ({
    valid: true,
    form: {
      prenom: '',
      name: '',
      addresse: '',
      email: ''
    },


    nameRules: [
      v => !!v || 'Name is required',
      // eslint-disable-next-line no-magic-numbers
      v => v && v.length <= 10 || 'Name must be less than 10 characters',
    ],
    email: '',
    emailRules: [
      v => !!v || 'E-mail is required',
      v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
    ],
    select: null,
    items: [
      'Item 1',
      'Item 2',
      'Item 3',
      'Item 4',
    ]
  }),
  computed :{
    params() {
      return {
        activity: this.activity,
        activityTypeExtension: this.activityTypeExtension,
      };
    },
    actionBarBorderClass() {
      return !this.isDesktop && 'border-top-color border-light-color' || '';
    },
    isDesktop() {
      return this.$vuetify && this.$vuetify.breakpoint && this.$vuetify.breakpoint.name !== 'xs' && this.$vuetify.breakpoint.name !== 'sm' && this.$vuetify.breakpoint.name !== 'md';
    },

  },
  methods: {
    validate () {
      console.log('response body 22222',this.form);
      this.add();
      this.$refs.form.validate();
      this.loadClients();

    },
    loadClients: function (){
      this.$emit('refresh-table');
      console.warn('loadClients');
    },
    add(){
      console.log('response body 1111',this.form);
      addClient(this.form).then(data => {
        console.warn('hii', data);
      });
    }
    
  },

};
</script>


<style scoped>
.modal-form{
  margin: 100px;
  border: aqua;

}

</style>
