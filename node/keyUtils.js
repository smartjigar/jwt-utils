const jwt = require('jsonwebtoken');
require("dotenv").config();

// Your public key string
// keys generated from https://www.devglan.com/online-tools/rsa-encryption-decryption
/*const publicKey = `-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyDxpM2bWlIl/66xfs4e3A46C21wWfMJEm4HT7A6VeUFPwZx/RJGgTsWAo1lHV3j8aHMQfkbmdBGrWSvX/EujbJ14JM/e10nzDqQVVFakfNA1uCr3OWhQ0TPsQT4KZ65sXLTawDnJSZd+Y39a8xqn5KKfv1cBxHjya8L1NRp/baTIoDD2e9s1LP/U1E0tKNURk4V2vhJNUKrp7GyK1C8NX0vBW6m+HETC2hFdRd5o36Y7ar/t4GkxcP6d3gNmjnTVvFsDtNTw3N+kCqU+rbYvI7Ui9RuPa+9UKUV2S1ZmPVoykAxRX4Np4AMqgcdTPRFXqn8xMLEkVI7RUzqfqYCzlQIDAQAB
-----END PUBLIC KEY-----`; */

const publicKey = `-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnLqUTl8PNVV/dYGxVxTgcSMM6OYbhnWeVe1IzqoXxKGbHeROrAz/FiQS0IhjCmN9+bv/jL9q/1CPapdqoR+G08GSZX2C03xHT9FSf6T9epgi+JO38EL2Vvh770TAp357Gg9bwVhPikwHWrAhH9gDfVCcBM5XYyxZWFQmmR+E16mGxvOuuvA+hYhjEeanoYUAU1IxRV+vzCmNKIUwGweqwe9j3rrX+4bS0mLG8hEcei9kS/682/2i2PQTQUfazkaVixmnknXU1Quu9qXZkUAI+uJl5jvYRJ9+CrX9VQMelgulepv5ItBqGXZII/0Qn+24omQo/ezzs4TePSHzNd7VgQIDAQAB
-----END PUBLIC KEY-----`;


// Example JWT token
const token = 'eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6ImR5bmFtbyIsImV4cCI6MTcyNDIyNjQ4MH0.G-t1rrFQFtxGyfc0m_k58YYx6iwF9-QMpm-jya5jubK3-MRcte7lBE_yntpZZxeOp6fszWwXAYtmNIGEQtPfxC_avjnQzc1VzuxjnTXtRDT1OwSreS4suamiL8VbVkZdTCo9xXihr5V5NT9y4BxiVI7zXwtO7dcrDdkxNWgLKaPZQmSCsPSW5eHYyLne1oAHRwnFZHUJV6G09YRJHz9Ou0_WA7o85a-c9R3mYsttStVRL0OLhztYXdpkCsRIhOlQsAFHVBRNwxytOmxUmvfbCIpOCh03IbMwZi_dSNr9O1OeSApHN7LsmVwBOXzOZDBZlhq5liIjE44K1FZjPb3Cwg';

// Verify the token

try {
    const decoded = jwt.verify(token, publicKey, { algorithms: ['RS256'] });
    console.log("JWT Verified Successfully");
    console.log(decoded);
} catch (err) {
    console.error("JWT Verification Failed:", err.message);
}