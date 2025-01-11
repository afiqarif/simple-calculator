import './App.css'
import React, { useState, useEffect } from "react";
import axios from 'axios'

function App() {
  const [data, setData] = useState(null);
  const [input1, setInput1] = useState("");
  const [input2, setInput2] = useState("");
  const [operator, setOperator] = useState("");
  const [error, setError] = useState(null);

  //Post data to backend
  const handlePostData = async () => {
    try {
      const response = await axios.post("http://192.168.0.105/api/data", {
        number_1: input1,
        number_2: input2,
        operator: operator
      });
      setData(response.data._resultCalc);
    } catch (err) {
      setError("Failed to post data...");
      console.error(err);
    }
  }

  return (
    <>
      <div className='background-bg'>
        <div>
          <div className='calculator-text'>
            <h1>This is a simple calculator</h1>
            {error && <p style={{ color: "darkred" }}>{error}</p>}
            <input 
              type="number"
              placeholder='Enter number...'
              value={input1}
              onChange={(e) => setInput1(e.target.value)}
            />
            <input 
              type="number"
              placeholder='Enter number...'
              value={input2}
              onChange={(e) => setInput2(e.target.value)}
            />
            <input 
              type="text"
              placeholder='Enter operator'
              value={operator}
              onChange={(e) => setOperator(e.target.value)}
            />
            <button onClick={handlePostData}>Submit</button>
            <h1 className='result-calc'>The result is: {data}</h1>
          </div>
        </div>
      </div>
    </>
  )
}

export default App
