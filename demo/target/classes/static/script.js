// DOM Elements
const inputField = document.querySelector("input");
const searchButton = document.querySelector("button");
const weatherInfo = document.querySelector(".weather-info");

// API Key and URL (replace 'YOUR_API_KEY' with an actual API key)
const API_KEY = "f7f8b77c8a0ad5342c40bca68bb3e183";
const BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=f7f8b77c8a0ad5342c40bca68bb3e183";

// Function to fetch weather data
async function getWeather(city) {
    try {
        const response = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=London&appid=f7f8b77c8a0ad5342c40bca68bb3e183`);
        if (!response.ok) throw new Error("City not found!");
        const data = await response.json();

        // Update the UI with weather data
        displayWeather(data);
    } catch (error) {
        displayError(error.message);
    }
}

// Function to display weather info
function displayWeather(data) {
    const { name, main, weather } = data;
    weatherInfo.innerHTML = `
        <h2>${name}</h2>
        <p>Temperature: ${main.temp}°C</p>
        <p>Feels Like: ${main.feels_like}°C</p>
        <p>Condition: ${weather[0].description}</p>
    `;
    weatherInfo.style.color = "#0077b6"; // Reset error message color
}

// Function to display error message
function displayError(message) {
    weatherInfo.innerHTML = `<p class="error">${message}</p>`;
}

// Event Listener
searchButton.addEventListener("click", () => {
    const city = inputField.value.trim();
    if (city) {
        getWeather(city);
    } else {
        displayError("Please enter a valid city name!");
    }
});
