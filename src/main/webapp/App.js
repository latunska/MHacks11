import React, { Component } from 'react';
import $ from 'jquery';
import logo from './thunder.svg';
import Ring from './Ring.svg';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.handleClick = this.handleClick.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.state = {newZip: false,validZip: false,uriForAudio: null,zip: null};
  } 
  handleClick = () => {
    console.log("Hello");
    var states = this.state;
    if(states.validZip){
	$.get("/WeatherData?zip="+states.zip,function(data){
	 var audio = document.getElementById("audio");
	 var source = document.getElementById("linky");
	 source.src = data;
	 audio.load();
	 audio.play();
	 $.get("/WeatherJson?zip="+states.zip, function(notData){
           var notnotData = notData.list[0].weather[0].id;
	   var symbol;
	   console.log(notnotData);
	   if(parseInt(notnotData)/100===2){
		symbol = "thunder";
	   }if(parseInt(notnotData)/100>=3){
		symbol = "rain";
	   }if(parseInt(notnotData)/100>=6){
		symbol = "snow";
	   }if(parseInt(notnotData)>=800){
		symbol = "sunny";
	   }if(parseInt(notnotData)>=802){
		symbol = "partsun";
	   }if(parseInt(notnotData)===804){
		symbol = "cloud";
	   }
	   document.getElementById("pic").src = symbol+".svg";	
	});
});

     // fetch('/WeatherData?zip='+states.zip)
      // .then(result=> {this.setState((state) =>
       // {return {newZip: false, validZip: true,uriForAudio: result,zip: state.zip}})}); 
    }
  }
  handleChange = (event) =>{
     var newVal =event.target.value;
     if(typeof parseInt(event.target.value) ==='number' && event.target.value.length===5){
   this.setState((state)=> { return{newZip:true,validZip:true,uriForAudio:state.uriForAudio,zip:newVal}});
     }else {
       this.setState((state)=> {return {newZip:true,validZip:false,uriForAudio:state.uriForAudio,zip:state.zip}});
     }
  }
  render() {
    return (
      <div className="App">
        <header className="App-header">
	  <div onClick={this.handleClick} className="App-img">
            <img id="pic" src={logo} className="App-logo" alt="logo" />
	    <img src={Ring} className="App-ring" alt="ring"/>
          </div>
          <p>
            <input onChange={this.handleChange} className="ZipCode" type= "text" placeholder="Enter a Zipcode"></input>
          </p>
	  <audio id="audio" controls loop="true">
		<source id="linky" src="" type="audio/mpeg"/>
		Get audio you jerk
	  </audio>
        </header>
      </div>
    );
  }
}

export default App;
