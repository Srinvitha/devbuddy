const button=document.getElementById("send");

button.onclick=async()=>{

    const message=document.getElementById("message").value;

    const data=await chatWithBuddy(message);

    document.getElementById("reply").innerHTML=data.reply;

}