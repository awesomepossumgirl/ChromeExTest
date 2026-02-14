document.addEventListener("DOMContentLoaded", () => {
  const urlInput = document.getElementById("urlInput");
  const shortUrlInput = document.getElementById("shortUrlInput");
  const shortenBtn = document.getElementById("shortenBtn");
  const copyBtn = document.getElementById("copyBtn");
  const historyList = document.getElementById("historyList");

  // URL 입력창 클릭 시 기존 값 비우기
  urlInput.addEventListener("focus", () => {
    urlInput.value = "";
  });

  // URL 줄이기 (TinyURL)
  shortenBtn.addEventListener("click", async () => {
    const url = urlInput.value.trim();
    if (!url) {
      alert("URL을 입력해줘");
      return;
    }

    try {
      const response = await fetch(
        "https://tinyurl.com/api-create.php?url=" +
          encodeURIComponent(url)
      );

      const shortUrl = await response.text();
      shortUrlInput.value = shortUrl;

      saveHistory(url, shortUrl);
      renderHistory();
    } catch (e) {
      alert("URL 줄이기에 실패했다");
    }
  });

  // 복사 버튼
  copyBtn.addEventListener("click", () => {
    if (!shortUrlInput.value) return;
    navigator.clipboard.writeText(shortUrlInput.value);
  });

  // 히스토리 저장
  function saveHistory(original, short) {
    const history = JSON.parse(localStorage.getItem("history") || "[]");
    history.unshift({ original, short });
    localStorage.setItem("history", JSON.stringify(history.slice(0, 10)));
  }

  // 히스토리 렌더링
  function renderHistory() {
    const history = JSON.parse(localStorage.getItem("history") || "[]");
    historyList.innerHTML = "";

    if (history.length === 0) {
      historyList.innerHTML =
        '<li class="list-group-item text-muted">아직 히스토리가 없다</li>';
      return;
    }

    history.forEach(item => {
      const li = document.createElement("li");
      li.className = "list-group-item";
      li.style.cursor = "pointer";
      li.innerHTML = `
        <div class="small text-muted text-truncate">${item.original}</div>
        <div class="fw-semibold">${item.short}</div>
      `;

      // 히스토리 클릭 시 복사
      li.addEventListener("click", () => {
        navigator.clipboard.writeText(item.short);
      });

      historyList.appendChild(li);
    });
  }

  renderHistory();
});
