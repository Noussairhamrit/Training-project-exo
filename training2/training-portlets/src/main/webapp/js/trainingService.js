
export function getusers () {
  return fetch(`${eXo.env.portal.context}/${eXo.env.portal.rest}/testapi/list/`, {
    method: 'GET',
    credentials: 'include',
  }).then(resp => {
    if (!resp || !resp.ok) {
      throw new Error('Response code indicates a server error', resp);
    } else {
      return resp.json();
    }
  });
}
export function testapinoussair (id) {
  return fetch(`${eXo.env.portal.context}/${eXo.env.portal.rest}/test/noussair/${id}`, {
    method: 'GET',
    credentials: 'include',
  }).then(resp => {
    if (!resp || !resp.ok) {
      throw new Error('Response code indicates a server error', resp);
    } else {
      return resp.json();
    }
  });
}
export function getAllClient () {
  return fetch(`${eXo.env.portal.context}/${eXo.env.portal.rest}/clients/all/`, {
    method: 'GET',
    credentials: 'include',
  }).then(resp => {
    if (!resp || !resp.ok) {
      throw new Error('Response code indicates a server error', resp);
    } else {
      return resp.json();
    }
  });
}
export function addClient (val) {
  return fetch(`${eXo.env.portal.context}/${eXo.env.portal.rest}/clients/add/`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(val)
  }).then(resp => {
    if (!resp || !resp.ok) {
      throw new Error('Response code indicates a server error', resp);
    } else {
      return resp.json();
    }
  });
}
export function deleteClient (id) {
  return fetch(`${eXo.env.portal.context}/${eXo.env.portal.rest}/clients/delete/${id}`, {
    method: 'Delete',
    credentials: 'include',
  }).then(resp => {
    if (!resp || !resp.ok) {
      throw new Error('Response code indicates a server error', resp);
    } else {
      return resp.json();
    }
  });
}
export function editClient (id,val) {
  return fetch(`${eXo.env.portal.context}/${eXo.env.portal.rest}/clients/edit/${id}`, {
    method: 'PATCH',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(val)
  }).then(resp => {
    if (!resp || !resp.ok) {
      throw new Error('Response code indicates a server error', resp);
    } else {
      return resp.json();
    }
  });
}
