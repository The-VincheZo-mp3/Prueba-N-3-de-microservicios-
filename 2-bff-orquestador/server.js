const express = require('express');
const cors = require('cors');
const axios = require('axios');
const app = express();
app.use(cors()); app.use(express.json());
const MS_JAVA_URL = 'http://localhost:8081/api/productos';
const MS_AUDITORIA_URL = 'http://localhost:8082/api/logs';
app.get('/api/dashboard', async (req, res) => {
    try {
        const resJava = await axios.get(MS_JAVA_URL).catch(() => ({ data: [] }));
        await axios.post(MS_AUDITORIA_URL, { evento: "Consulta de catalogo" }).catch(() => null);
        res.json({ mensajeBff: "Orquestacion unificada exitosamente por el BFF", productos: resJava.data });
    } catch (error) { res.status(500).json({ error: error.message }); }
});
app.listen(8080, () => console.log('BFF operando en puerto 8080'));
