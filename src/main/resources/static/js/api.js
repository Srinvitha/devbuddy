async function getHealth(){

    const response = await fetch("/api/health");

    return await response.json();

}