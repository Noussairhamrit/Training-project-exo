<template>

  <v-data-table
    :headers="headers"
    :items="clientArray"
    sort-by="calories"
    class="elevation-1"
  >
    <template v-slot:top>
      <v-toolbar
        flat
      >
        <v-toolbar-title>My CRUD</v-toolbar-title>
        <v-divider
          class="mx-4"
          inset
          vertical
        />
        <v-spacer />
        <v-dialog
          v-model="dialog"
          max-width="500px"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              color="primary"
              dark
              class="mb-2"
              v-bind="attrs"
              v-on="on"
            >
              New Item
            </v-btn>
          </template>
          <v-card>
            <v-card-title>
              <span class="text-h5">{{ formTitle }}</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.name"
                      label="Name"
                    />
                  </v-col>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.prenom"
                      label="Prenom"
                    />
                  </v-col>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.addresse"
                      label="Addresse"
                    />
                  </v-col>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.email"
                      label="Email"
                    />
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer />
              <v-btn
                color="blue darken-1"
                text
                @click="close"
              >
                Cancel
              </v-btn>
              <v-btn
                color="blue darken-1"
                text
                @click="save"
              >
                Save New
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <v-dialog v-model="dialogDelete" max-width="500px">
          <v-card>
            <v-card-title class="text-h5">
              Are you sure you want to delete this item?
            </v-card-title>
            <v-card-actions>
              <v-spacer />
              <v-btn
                color="blue darken-1"
                text
                @click="closeDelete"
              >
                Cancel
              </v-btn>
              <v-btn
                color="blue darken-1"
                text
                @click="deleteItemConfirm(item) "
              >
                OK
              </v-btn>
              <v-spacer />
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>
    <template v-slot:item.actions="{ item }">
      <v-icon
        small
        class="mr-2"
        @click="editItem(item)"
      >
        mdi-pencil
      </v-icon>
      <v-icon
        small
        @click="deleteItem(item)"
      >
        mdi-delete
      </v-icon>
    </template>
    <template v-slot:no-data>
      <v-btn
        color="primary"
        @click="initialize"
      >
        Reset
      </v-btn>
    </template>

  </v-data-table>
</template>
<script>
import {addClient, deleteClient, editClient, getAllClient} from '../../../js/trainingService.js';

export default {
  name: 'CrudClient',
  data: () => ({
    dialog: false,
    dialogDelete: false,
    headers: [
      {
        text: 'id',
        align: 'start',
        sortable: false,
        value: 'id',
      },
      {text: 'prenom', value: 'prenom'},
      {text: 'name', value: 'name'},
      {text: 'addresse', value: 'addresse'},
      {text: 'email', value: 'email'},
      { text: 'Actions', value: 'actions', sortable: false },
    ],
    client: [],

    editedIndex: -1,
    Index: Number,
    editedItem: {
      name: '',
      addresse: '',
      prenom: '',
      email: ''
    },
    defaultItem: {
      name: '',
      calories: 0,
      fat: 0,
      carbs: 0,
      protein: 0,
    },
  }),

  computed: {
    formTitle () {
      return this.editedIndex === -1 ? 'New Item' : 'Edit Item';
    },
    clientArray(){
      return this.client;
    }
  },

  watch: {
    dialog (val) {
      // eslint-disable-next-line no-unused-expressions
      val || this.close();
    },
    dialogDelete (val) {
      // eslint-disable-next-line no-unused-expressions
      val || this.closeDelete();
    },
  },
  mounted() {
    this.allClients() ;
    console.log('cconsole.log  mounted crud',this.client);
  },

  methods: {
    allClients(){
      return  getAllClient().then(data=>{
        this.client=data;
        console.log('coonsole.log methods crud',this.client);
      }).catch(error => console.log(error));
    },

    editItem (item) {
      this.editedIndex = item.id;
      this.Index = item.id;
      this.editedItem = Object.assign({}, item);
      this.dialog = true;

    },

    deleteItem (item) {
      this.Index=item.id;
      console.log('iiiiiiii',typeof this.Index);
      // this.editedItem = Object.assign({}, item);
      this.dialogDelete = true;
    },

    deleteItemConfirm () {
      console.log('jjjjjjjjjj',typeof this.Index);
      this.del(this.Index);
      this.closeDelete();
    },

    close () {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    closeDelete () {
      this.dialogDelete = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    save () {
      if (this.editedIndex > -1) {
        this.edit(this.Index,this.editedItem);
      } else {
        this.add(this.editedItem);
      }
      this.close();

    },
    del(id){
      return deleteClient(id);

    },
    edit(id ,val){
      return  editClient(id,val);
    },
    add(val){
      return  addClient(val);
    }
  },
};
</script>
<style scoped>
.mb-2{
  color: #676767;
  font-weight: bold;
}
</style>