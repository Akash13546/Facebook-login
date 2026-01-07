function login() {
  fetch("/api/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      username: username.value,
      password: password.value
    })
  })
  .then(res => {
    if (!res.ok) throw new Error("Invalid credentials");
    return res.text();
  })
  .then(() => {
    localStorage.setItem("loggedIn", "true");
    window.location.href = "dashboard.html";
  })
  .catch(err => error.innerText = err.message);
}
