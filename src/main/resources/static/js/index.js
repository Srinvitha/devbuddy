window.onload = async () => {
    const health = await getHealth();
    console.log(health);
};