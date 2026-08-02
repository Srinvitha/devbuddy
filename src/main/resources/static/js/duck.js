const chat=document.getElementById("chat");

const button=document.getElementById("send");

const history=[];

button.onclick=async()=>{

    const textarea=document.getElementById("message");

    const question=textarea.value.trim();

    if(question==="") return;

    history.push({

        role:"User",

        message:question

    });

    chat.innerHTML+=`

        <div class="user">

            ${question}

        </div>

    `;

    textarea.value="";

    chat.innerHTML+=`

        <div class="ai" id="loading">

            Thinking...

        </div>

    `;

    chat.scrollTop=chat.scrollHeight;

    const data=await chatWithDuck(history);

    document.getElementById("loading").remove();

    history.push({

        role:"Assistant",

        message:data.reply

    });

    chat.innerHTML+=`

        <div class="ai">

            ${data.reply}

        </div>

    `;

    chat.scrollTop=chat.scrollHeight;

};

document
.getElementById("message")
.addEventListener("keydown",(e)=>{

    if(e.key==="Enter" && !e.shiftKey){

        e.preventDefault();

        button.click();

    }

});