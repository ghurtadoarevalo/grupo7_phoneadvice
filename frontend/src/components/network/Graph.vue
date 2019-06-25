<template>
<v-container>
    <v-layout row wrap>
      <ul class="menu">
        <li>
          <label> Node size  </label>
          <input type="range" min="1" max="100" v-model='nodeSize' /> {{ options.nodeSize }}
        </li>  
      </ul>
    </v-layout>
    <v-layout row wrap>
        <d3-network :net-nodes="nodes" :net-links="links" :options="options"></d3-network>
    </v-layout>
</v-container>
</template>

<script >
  import D3Network from 'vue-d3-network'
  var userIcon = `<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" aria-hidden="true" focusable="false" width="1em" height="1em" style="-ms-transform: rotate(360deg); -webkit-transform: rotate(360deg); transform: rotate(360deg);" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path d="M12 4a4 4 0 1 1 0 8 4 4 0 0 1 0-8zm0 10c4.418 0 8 1.79 8 4v2H4v-2c0-2.21 3.582-4 8-4z" fill="rgb(96, 181, 230)"/></svg>`
  var phoneIcon = `<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" aria-hidden="true" focusable="false" width="1em" height="1em" style="-ms-transform: rotate(360deg); -webkit-transform: rotate(360deg); transform: rotate(360deg);" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path d="M17 18.998H7v-14h10m0-3.99L7 .998a2 2 0 0 0-2 2v18a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2v-18c0-1.104-.897-1.99-2-1.99z" fill="rgb(96, 181, 230)"/></svg>`
  export default {
    name: 'NetworkGraph',
    components: {
      D3Network,
    },
    data() {
      return {
        nodes: [
        { id: 1, name: 'User 0' ,_size: 40, svgSym:userIcon},
        { id: 2, name: 'User 1' , svgSym:userIcon},
        { id: 3, name: 'User 2', _size: 30, svgSym:userIcon },
        { id: 4, name: 'User 3' , svgSym:userIcon},
        { id: 5, name: 'User 4' , svgSym:userIcon},
        { id: 6, name: 'Phone 1' , svgSym:phoneIcon},
        { id: 7, name: 'Phone 2' , svgSym:phoneIcon},
        { id: 8, name: 'Phone 3' , svgSym:phoneIcon},
        { id: 9, name: 'Phone 4' , svgSym:phoneIcon}
      ],
      links: [
        { sid: 1, tid: 2,},
        { sid: 1, tid: 3,},
        { sid: 1, tid: 4,},
        { sid: 1, tid: 5,},
        { sid: 2, tid: 8,},
        { sid: 2, tid: 9,},
        { sid: 3, tid: 6 },
        { sid: 3, tid: 7 },
        { sid: 4, tid: 7 },
        { sid: 4, tid: 8 },
        { sid: 5, tid: 9 },
        { sid: 1, tid: 6 },
      ],
      nodeSize:30,

      }
    },
    methods: {
      //
    },
    computed:{
    options(){
      return{
        force: 3000,
        size:{ w:900, h:600},
        nodeSize: this.nodeSize,
        nodeLabels: true,
        linkWidth:2
      }
    }
  }

  }
</script>
<style>
ul.menu {
  list-style: none;
  position: absolute;
  z-index: 100;
  min-width: 20em;
  text-align: left;
}
ul.menu li{
  margin-top: 1em;
  position: relative;
}
.net{
    height:100%;
    margin:0
}
.node{
    stroke: #0E318A;
    stroke-width:1px;
    -webkit-transition:fill .5s ease;
    transition:fill .5s ease;
    fill:rgb(96, 181, 230);
    }
.node.selected{
    stroke:#caa455
}
.node.pinned{
    stroke:rgba(190,56,93,.6)
}
.link{
    stroke:rgb(96, 181, 230)
}
.link,.node{
    stroke-linecap:round
}
.link:hover,.node:hover{
    stroke:#0E318A;
    stroke-width:2px
}
.link.selected{
    stroke:rgba(202,164,85,.6)
}
.curve{
    fill:none
}
.link-label,.node-label{
    fill:#127862
}
.link-label{
    -webkit-transform:translateY(-.5em);
    transform:translateY(-.5em);
    text-anchor:middle
}

</style>
