import React, { useEffect, useState } from 'react'
import Header from '../components/Header'
import Menu from '../components/Menu'
import Banner from '../components/Banner'
import HorizontalImageList from '../components/HorizontalImageList'
import CategoryList from '../components/CategoryList'
import NewFeature from '../components/NewFeature'
import { isAuthenticated } from '../services/api'
import { useNavigate } from 'react-router-dom';

const HomePage = () => {
    const navigate = useNavigate();

    const [isLogin, setIsLogin] = useState(false);

    useEffect(() => {
        const checkAuthentication = async () => {
          const authenticated = await isAuthenticated();
          if (!authenticated) {
            // navigate('/login');
             setIsLogin(false);
          } else {

            setIsLogin(true);
          }
        };
          // eslint-disable-next-line react-hooks/exhaustive-deps
        checkAuthentication();
      }, []);


    return (
        <div className='flex flex-col w-screen h-auto'>

            <Header />
            <Menu isLogin = {isLogin} />
            <Banner/>
            <HorizontalImageList/>
            <CategoryList/>
            <NewFeature/>

        </div>
    )
}

export default HomePage