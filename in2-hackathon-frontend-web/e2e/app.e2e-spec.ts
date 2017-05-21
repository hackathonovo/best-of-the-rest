import { In2HackathonFrontendWebPage } from './app.po';

describe('in2-hackathon-frontend-web App', function() {
  let page: In2HackathonFrontendWebPage;

  beforeEach(() => {
    page = new In2HackathonFrontendWebPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
