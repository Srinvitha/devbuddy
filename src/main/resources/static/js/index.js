window.addEventListener("load", async () => {

    try{

        const health = await getHealth();

        console.log("Backend Connected");

        console.log(health);

    }

    catch(error){

        console.error(error);

    }

});