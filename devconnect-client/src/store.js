import {createStore,applyMiddleware,compose} from 'redux'
import thunk from 'redux-thunk'
import reducer from './reducers'

const initState = {}
const middleWare = [thunk]

let store =createStore(reducer,initState,compose(applyMiddleware(...middleWare)))

// if (window.navigator.userAgent.includes("Chrome")) {
//   // store = createStore(reducer,initState,compose(applyMiddleware(...middleWare),window._REDUX_DEVTOOLS_EXTENSION_ && window._REDUX_DEVTOOLS_EXTENSIONS_()))
// } else {
//   store = createStore(reducer,initState,compose(applyMiddleware(...middleWare)))
// }

export default store