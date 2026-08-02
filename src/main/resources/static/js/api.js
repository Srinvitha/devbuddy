async function getHealth(){

    const response = await fetch("/api/health");

    return await response.json();

}

async function chatWithBuddy(message){

    const response = await fetch("/api/buddy/chat",{

        method:"POST",

        headers:{
            "Content-Type":"application/json"
        },

        body:JSON.stringify({

            message:message

        })

    });

    return await response.json();

}