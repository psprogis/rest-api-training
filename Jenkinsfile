node {
    stage ("checkout repo") {
        git branch: 'master',
            // credentialsId
            url: 'https://github.com/psprogis/rest-api-training.git'
    }

    stage ("build") {
        sh "./gradlew clean api-test:assemble"
    }

    stage ("run api tests") {
        sh "./gradlew api-test:test"
    }

    stage ("run ui tests") {
        sh "./gradlew ui-test:test"
    }

    allure([
            includeProperties: false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: 'api-test/build/allure-results'], [path: 'ui-test/build/allure-results']]
    ])

    // TODO: add baseUrl as a parameter
}