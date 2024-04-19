import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { isAuthenticated, loginRequest } from '../services/api';

const LoginPage = () => {
    const navigate = useNavigate();

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');


    
  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log("email:", email);
    console.log("password:", password);
    const result = await loginRequest(email, password);
    if(result.success===200){
      const token = result.data.message;
      const user = result.data
      //login(token, user);
      navigate('/home');
      
    }else {
      console.log("resultLogin:", result);
    }
   // navigate('/admin');
    setEmail('');
    setPassword('');
  };

  useEffect(() => {
    const checkAuthentication = async () => {
      const authenticated = await isAuthenticated();
      if (authenticated) {
         navigate('/home');
      } else {
      }
    };
      // eslint-disable-next-line react-hooks/exhaustive-deps
    checkAuthentication();
  }, []);


    return (
        <div className='flex items-center justify-center w-screen h-screen bg-green-600'>

            <div className='flex flex-col w-1/4 h-auto rounded-lg'>

                <form className="px-[32px] pt-6 pb-8 mb-4 bg-white rounded shadow-md h-2/3">
                    <div className="mb-4">
                        <label className="block mb-2 text-sm font-bold text-gray-700" htmlFor="email">
                            Email
                        </label>
                        <input onChange={handleEmailChange} value={email}
                            className="w-full px-3 py-2 leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                            id="email"
                            type="email"
                            placeholder="Enter your email"
                        />
                    </div>
                    <div className="mb-6">
                        <label className="block mb-2 text-sm font-bold text-gray-700" htmlFor="password">
                            Password
                        </label>
                        <input onChange={handlePasswordChange}
                        value={password}
                            className="w-full px-3 py-2 leading-tight text-gray-700 border rounded shadow appearance-none focus:outline-none focus:shadow-outline"
                            id="password"
                            type="password"
                            placeholder="Enter your password"
                        />
                    </div>
                    <div className="flex items-center justify-between">
                        <button onClick={handleSubmit}
                            className="px-4 py-2 font-bold text-white bg-blue-500 rounded hover:bg-blue-700 focus:outline-none focus:shadow-outline"
                            type="button"
                        >
                            Log In
                        </button>
                        <a
                            className="inline-block text-sm font-bold text-blue-500 align-baseline hover:text-blue-800"
                            href="#"
                        >
                            Forgot Password?
                        </a>
                    </div>
                </form>
            </div>


        </div>
    )
}

export default LoginPage