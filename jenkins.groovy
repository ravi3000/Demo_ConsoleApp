node
{
  stage ‘SCM’
  {
  echo “Gathering code form version control”
  }
  stage ‘BUILD’
  {
    echo “Building”
  }
  stage ‘TEST’
  {
    echo “Testing”
  }
  stage ‘DEPLOY’
  {
    echo "Deploying"
  }
}
