const express = require('express');
const cors = require('cors');
const app = express();
app.use(cors()); app.use(express.json());
let logs = [];
app.post('/api/logs', (req, res) => {
    const nuevoLog = { id: logs.length + 1, evento: req.body.evento, fecha: new Date() };
    logs.push(nuevoLog);
    console.log('[LOG CAPTURADO]: ' + nuevoLog.evento);
    res.status(201).json(nuevoLog);
});
app.get('/api/logs', (req, res) => res.json(logs));
app.listen(8082, () => console.log('MS Auditoria operando en puerto 8082'));
